package learn.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SimpleServer {

    void start() {
        try {
            Selector selector = Selector.open();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.socket().bind(new InetSocketAddress(8088));

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if (selector.select(1000) == 0) {
                    System.out.println("...");
                }


                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println("selectionKeys.size: " + selectionKeys.size());
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey key = null;
                while (iterator.hasNext()) {
                    key = iterator.next();
                    iterator.remove();
                    System.out.println("remove selectionKey");
                    if (key.isValid()) {
                        System.out.println("key.isValid " + key.readyOps());
                        if (key.isAcceptable()) {
                            System.out.println("key.isAcceptable");
                            ServerSocketChannel scc = (ServerSocketChannel) key.channel();

                            SocketChannel socketChannel = scc.accept();
                            System.out.println("accept success");

                            socketChannel.configureBlocking(false);

                            socketChannel.register(selector, SelectionKey.OP_READ);
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

//                            key.interestOps(SelectionKey.OP_WRITE);
                        } else if (key.isWritable()) {
                            System.out.println("key.isWritable");
//                            key.interestOps(SelectionKey.OP_READ);
                        } else if (key.isConnectable()) {
                            System.out.println("key.isConnectable");
                        }
                    }
                }
                TimeUnit.SECONDS.sleep(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimpleServer().start();
    }
}
