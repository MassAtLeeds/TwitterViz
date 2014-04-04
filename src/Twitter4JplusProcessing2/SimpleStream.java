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

                // gets Username
                String username = status.getUser().getScreenName();
                System.out.println(username);
                String profileLocation = user.getLocation();
                System.out.println(profileLocation);
                long tweetId = status.getId();
                System.out.println(tweetId);
                String content = status.getText();
                System.out.println(content + "\n");

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

        String keywords[] = {"leeds, Leeds"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);

    }
}
