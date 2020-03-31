package rss.bbc_top_news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import java.util.LinkedList;


import android.widget.ArrayAdapter;
import android.widget.ListView;

//
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RSSReader rssReader = new RSSReader();
    RSSParser rssParser = new RSSParser();
    AsyncRSSParser asyncRSSParser = new AsyncRSSParser();


    private ListView ListView_LIST;
    private ArrayAdapter arrayAdapter;

    //
    private TextView TextView_TEXTVIEW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView_LIST = findViewById(R.id.ListView_LIST);

        //
        TextView_TEXTVIEW = findViewById(R.id.TextView_TEXTVIEW);


        asyncRSSParser.execute();

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ListView_LIST.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the selected name
                String selectedTitle = (String)parent.getItemAtPosition(position);

                // Look for Selected Title, once found
                // Display the details of the Title in TextView_TEXTVIEW
                for(int i = 0; i < rssParser.topStoryList.size();i++)
                {
                    if(selectedTitle.equals(rssParser.topStoryList.get(i).getTitle()))
                    {
                        TextView_TEXTVIEW.setText(rssParser.topStoryList.get(i).toString());
                        break;
                        // END
                    }
                }


            }
        });

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
