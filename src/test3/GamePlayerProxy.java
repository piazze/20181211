package test3;

public class GamePlayerProxy implements IGamePlayer {

    //被代理的对象
    private IGamePlayer player;

    /**
     * 实例化代理对象时，传递被代理对象
     * @param player
     */
    public GamePlayerProxy(IGamePlayer player) {
        this.player = player;
    }

    @Override
    public void login(String user, String pwd) {
        this.player.login(user,pwd);
    }

    @Override
    public void killBoos() {
        this.player.killBoos();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
    }
}
