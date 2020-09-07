package learn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SimpleClient {

    void start() {
        Selector selector = null;
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8088));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            selector.select(1000);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("client selectionKeys.size: " + selectionKeys.size());
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isValid()) {
                    System.out.println("key.isValid " + key.readyOps());
                    if (key.isAcceptable()) {
                        System.out.println("key.isAcceptable");
                        ServerSocketChannel scc = (ServerSocketChannel) key.channel();
                        SocketChannel newSc = scc.accept();
                        System.out.println("accept success");
                        newSc.configureBlocking(false);
                        newSc.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        System.out.println("key.isReadable ");
                        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
                        SocketChannel channel = ((SocketChannel)key.channel());
                        if (channel.read(byteBuffer) == -1) {
                            System.out.println("channel should close");
                            key.cancel();
                            channel.close();
                        } else {
                            System.out.println("read next");
                        }
                    } else if (key.isWritable()) {
                        System.out.println("key.isWritable");
                    } else if (key.isConnectable()) {
                        System.out.println("key.isConnectable");
                    }
                }
            }
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SimpleClient().start();
    }
}
