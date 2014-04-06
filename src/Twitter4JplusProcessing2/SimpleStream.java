package Twitter4JplusProcessing2;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 * nabbed from http://davidcrowley.me/?p=435
 *
 * @author geodo
 */
public class SimpleStream {

    public SimpleStream() {

//    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("ua0EmDn1HgKXldXlzV78N5Waq");
        //AuthSecrets: class hidden via gitignore, just returns secret strings
        cb.setOAuthConsumerSecret(AuthSecrets.getConsumerTokenSecret());
        //AuthSecrets: class hidden via gitignore, just returns secret strings
        cb.setOAuthAccessToken("398915413-QCdAtpoathxwghvFHdMS0csnr8sz4tAAmB6m9URF");
//        cb.setOAuthAccessToken("398915413-QCdAtpoathxwghvFHdMS0csnr8sz4tAAmB6m9URF");

        cb.setOAuthAccessTokenSecret(AuthSecrets.getAccessTokenSecret());

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {

            @Override
            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStatus(Status status) {
                User user = status.getUser();

                //filter for keyword internally, since the streaming API is on "OR" relationship
                String content = status.getText();

                if (content.contains("the ") || content.contains("The ")) {

                    //http://stackoverflow.com/questions/1166905/hints-for-java-lang-string-replace-problem
                    content = content.replaceAll("the ", "**THE** ");
                    content = content.replaceAll("The ", "**THE** ");
                    //get rest of output
                    // gets Username
                    String username = status.getUser().getScreenName();
                    System.out.println(username);
                    String profileLocation = user.getLocation();
                    System.out.println(profileLocation);
                    //long tweetId = status.getId();
                    //System.out.println(tweetId);
                    System.out.println(content + "\n");
                }

            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStallWarning(StallWarning sw) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };

        FilterQuery fq = new FilterQuery();

//        String keywords[] = {"cycle, Bicycle, bike"};
//        fq.track(keywords);
        //double e[][] = {{-122.75, 36.8}, {-121.75, 37.8}};
        //california
//        fq.locations(new double[][]{{-122.75, 36.8}, {-121.75, 37.8}});
        //
        fq.locations(new double[][]{{-2.17, 53.52}, {-1.20, 53.96}});

        twitterStream.addListener(listener);
        twitterStream.filter(fq);

    }
}
