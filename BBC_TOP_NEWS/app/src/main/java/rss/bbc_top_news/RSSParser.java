package rss.bbc_top_news;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;


public class RSSParser
{
    // Linked List containing top stories each with its own title, description and publication date
    LinkedList <TopStory> topStoryList = null;


    public LinkedList<TopStory> parseRSSString(String rssString)
    {
        TopStory topStory = null;

        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput( new StringReader( rssString ) );
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT)
            {

                // Found a start tag
                if(eventType == XmlPullParser.START_TAG)
                {
                    // Check which Tag we have
                    if (xpp.getName().equalsIgnoreCase("channel"))
                    {
                        topStoryList  = new LinkedList<TopStory>();
                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        topStory = new TopStory();
                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("title"))
                    {
                        // Now just get the associated text
                        String temp = xpp.nextText();
                        topStory.setTitle(temp);
                    }
                    else
                        // Check which Tag we have
                        if (xpp.getName().equalsIgnoreCase("description"))
                        {
                            // Now just get the associated text
                            String temp = xpp.nextText();
                            topStory.setDescription(temp);
                        }
                        else
                            // Check which Tag we have
                            if (xpp.getName().equalsIgnoreCase("pubDate"))
                            {
                                // Now just get the associated text
                                String temp = xpp.nextText();
                                topStory.setPubDate(temp);
                            }
                }
                else
                if(eventType == XmlPullParser.END_TAG)
                {
                    if (xpp.getName().equalsIgnoreCase("item"))
                    {
                        topStoryList.add(topStory);
                    }
                    else
                    if (xpp.getName().equalsIgnoreCase("channel"))
                    {
                        int size;
                        size = topStoryList.size();
                        System.out.println(size + " Top Stories Parsed");
                    }
                }

                // Get the next event
                eventType = xpp.next();
            }

        }

        catch (XmlPullParserException e)
        {
            System.out.println("Parsing Error "+e.toString());
        }

        catch (IOException e)
        {
            System.out.println("Parsing Error "+e.toString());
        }
        return topStoryList;
    }

    // THE END
}
