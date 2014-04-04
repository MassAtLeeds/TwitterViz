package Twitter4JplusProcessing2;

/**
 * Don't forget to change the package and Main class name when duplicating
 *
 * @author geodo
 */
import processing.core.*;

public class Main extends PApplet {

    @Override
    public void setup() {

        //The default mode (just size(800,800) is more accurate but slower. 
        //Both P2D and P3D use openGL by default
        size(800, 800, P2D);

        try {
            new TwitterStreamer();
        } catch (Exception e) {

        }

    }

    @Override
    public void draw() {

        background(255);
        line(0, 0, width, height);

    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"Twitter4JplusProcessing2.Main"});
    }
}
