package com.fraeds.fragmentcommunication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.LinkedList;


// This Fragment holds a list of persons, but only displays the names of the persons
// in the ListView
public class FragmentA extends Fragment {



    ////////////////////////////////////////////////////////////////////////////////////////////////
    private ListView ListView_NAMES;
    private ArrayAdapter<String> arrayAdapter;
    LinkedList<Person> personLinkedList = new LinkedList<Person>();
    LinkedList<String> personName = new LinkedList<String>();
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public FragmentA()
    {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        ////////////////////////////////////////////////////////////////////////////////////////////////
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        // Find ListView_NAMES its by ID in the root
        ListView_NAMES = (ListView)view.findViewById(R.id.ListView_NAMES);


        // Create two people and add them to LinkedList
        Person ruslan = new Person("Ruslan Masinjila",50,"+1234567890","abc@gmail.com","Pemba");
        Person mamba =  new Person("Dr. Who",100,"+0987654321","zyx@gmail.com","Wakanda");

        personLinkedList.add(ruslan);
        personName.add(ruslan.getName());

        personLinkedList.add(mamba);
        personName.add(mamba.getName());



        // Create Array Adapter for the list
        arrayAdapter =  new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, personName);

        ListView_NAMES.setAdapter(arrayAdapter);
        ////////////////////////////////////////////////////////////////////////////////////////////////


        return view;
    }


}
