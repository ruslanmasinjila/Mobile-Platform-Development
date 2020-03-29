package rss.bbc_top_news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import java.util.LinkedList;

//
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    RSSReader rssReader = new RSSReader();
    RSSParser rssParser = new RSSParser();
    AsyncRSSParser asyncRSSParser = new AsyncRSSParser();

    //
    private ListView ListView_LIST;
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        ListView_LIST = findViewById(R.id.ListView_LIST);

        asyncRSSParser.execute();

    }

    private class AsyncRSSParser extends AsyncTask<Void, Void, LinkedList<TopStory>> {


        protected LinkedList<TopStory> doInBackground(Void... nothing) {
            LinkedList<TopStory> topStoryList = null;

            // Fetch RSS data from BBC News
            rssReader.FetchRSS();

            // Parse the xml of the RSS into a LinkedList of Top Stories
            rssParser.parseRSSString(rssReader.getRssString());

            // Return the LinkedList containing Top Stories
            return rssParser.topStoryList;
        }

        // Print the First Element from the topStoryList returned by doInBackground()
        protected void onPostExecute(LinkedList<TopStory> topStoryList) {

            arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, rssParser.titleList);
            ListView_LIST.setAdapter(arrayAdapter);
            // END
        }

    }


}
