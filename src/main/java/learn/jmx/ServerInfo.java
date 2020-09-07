package learn.jmx;

public class ServerInfo implements ServerInfoMBean{

    @Override
    public int getExecutedSqlCmdCount() {
        return 5;
    }
}
