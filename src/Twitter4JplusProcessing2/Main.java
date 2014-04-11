package Twitter4JplusProcessing2;

/**
 * Don't forget to change the package and Main class name when duplicating
 *
 * @author geodo
 */
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.geo.*;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.*;
import processing.core.*;
import twitter4j.GeoLocation;

public class Main extends PApplet {

    static UnfoldingMap map;
//    static GeoLocation geoloc;

    @Override
    public void setup() {

        //The default mode (just size(800,800) is more accurate but slower. 
        //Both P2D and P3D use openGL by default
        size(800, 800, P2D);

        map = new UnfoldingMap(this);
        map.zoomAndPanTo(new Location(53.7997, -1.5492), 10);
        MapUtils.createDefaultEventDispatcher(this, map);

        //constructor gets properties from tw.properties
        new Utils();
        
        System.out.println("access key: " + Utils.accessTokenKey);
        System.out.println("access secret: " + Utils.accessTokenSecret);
        System.out.println("consumer key: " + Utils.consumerTokenKey);
        System.out.println("consumer secret: " + Utils.consumerTokenSecret);
        
        try {
            new SimpleStream();
        } catch (Exception e) {

        }

    }

    @Override
    public void draw() {

        try {
            map.draw();
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"Twitter4JplusProcessing2.Main"});
    }
}
