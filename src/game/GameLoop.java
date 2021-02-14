package game;

public class GameLoop implements Runnable{
    private Game game;

    private boolean running;
    private final double updateRate = 1.00/60d;
    private long nextStateTime;
    private int fps, ups;
public GameLoop(Game game ){
    this.game = game;
}

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextStateTime = System.currentTimeMillis() + 1000;

        while(running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeSecond = (currentTime -lastUpdate) / 1000d;
            accumulator += lastRenderTimeSecond;
            lastUpdate = currentTime;
            if (accumulator >= updateRate) {
                while (accumulator > updateRate) {
                    update();
                    accumulator -= updateRate;

                }
                render();
            }
            printStats();

        }
    }
    private void printStats(){
        if(System.currentTimeMillis()> nextStateTime){
            System.out.println(String.format("fps: %d,UPS: %d",fps ,ups));
            fps = 0;
            ups = 0;
            nextStateTime = System.currentTimeMillis() +1000;
        }
    }
    private void render(){
        game.render();
    fps++;
    }
    private void update(){
      game.update();
    ups++;

    }
}
