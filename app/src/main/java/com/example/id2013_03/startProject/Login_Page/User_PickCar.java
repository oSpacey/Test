package com.example.id2013_03.startProject.Login_Page;

// Importing some java functions for this class
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Importing the android functions needed
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

// Importing the packages needed to get this class working
import com.example.id2013_03.startProject.Tabbed_Pages.Tab_Main;
import com.example.id2013_03.mclaren.R;

// This class is for the car selection
// This is simply a list of cars for the salesman to choose from
public class User_PickCar extends Activity{
    // Variables used within this class
    List<String> ChildList;
    Map<String, List<String>> ParentListItems;
    ExpandableListView expandablelistView;

    // Assigning the parent list items
    // These are the items that are clicked before displaying more information
    // More can be added easily by following the same functionality as below
    List<String> ParentList = new ArrayList<String>();
    {
        ParentList.add("600 Series");
        ParentList.add("500 Series");
    }

    // Assigning the children list elements using the string array
    // These are the elements that are displayed once one of the head menus have been clicked
    // Again more can be added simply but following the same functionality as below
    String [] sixSeries = {"675 LT", "650S Spider", "650S Coupe", "650S CAN-AM-SPIDER"};
    String [] fiveSeries = {"570S", "570 GT", "540C"};
    String [] ByDefaultMessage = {"Items Loading"};

    @Override
    // Function for when the page is loaded / created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setting the view for this class
        setContentView(R.layout.login_car);

        // Parenting the Heading items for the menu
        ParentListItems = new LinkedHashMap<String, List<String>>();
        // For loop to check which Heading it is and matching that
        // by loading the child items within the statment
        // More can be added by simply adding more "else if" functions to this section of the code
        for (String HoldItem : ParentList)
        {
            if (HoldItem.equals("600 Series"))
            {
                loadChild(sixSeries);
            } else if (HoldItem.equals("500 Series"))
                loadChild(fiveSeries);
            else
                loadChild(ByDefaultMessage);
            ParentListItems.put(HoldItem, ChildList);
        }

        // Placing the right view id for the expandable list that was created within the xml file
        expandablelistView = (ExpandableListView)findViewById(R.id.expandableListView1);
        // Finally taking the explandable list and creating a new adapter...
        // This takes in the parent list which is the headings for the drop down menus
        // it also takes the parent list items which are the sub headings that can also take
        // the users to the new Main activities
        final ExpandableListAdapter expListAdapter = new ListAdapter(this, ParentList, ParentListItems);
        // Setting the adapter with the variable expandablelistView variable
        expandablelistView.setAdapter(expListAdapter);
        // Setting the on click listener for the menu... This on click is for opening the main menu and
        // also for once the child objects are clicked and what they should do once they have been clicked
        expandablelistView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
            {
                // This checks which Menu has been selected
                // It then displays the children of that menu that the users have selected
                final String selected = (String) expListAdapter.getChild(groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection...
                Intent intent;
                switch(selected)
                {
                    // These are teh sub menus within the main menus
                    // This is where you can also decided what happens if the user happens to click one of them
                    // For now, most of the items have a Toast added. (This is just simply a notification)
                    // If you look at the 650S Spider you can see that it actually starts up the app with the settings for that
                    case "675 LT":
                        Toast.makeText(getApplicationContext(),"Not yet implemented", Toast.LENGTH_LONG).show();
                        break;
                    case "650S Spider":
                        intent = new Intent(User_PickCar.this, Tab_Main.class);
                        startActivity(intent);
                        break;
                    case "650S Coupe":
                        Toast.makeText(getApplicationContext(),"Not yet implemented", Toast.LENGTH_LONG).show();
                        break;
                    case "650S CAN-AM-SPIDER":
                        Toast.makeText(getApplicationContext(),"Not yet implemented", Toast.LENGTH_LONG).show();
                        break;
                    case "570S":
                        Toast.makeText(getApplicationContext(),"Not yet implemented", Toast.LENGTH_LONG).show();
                        break;
                    case "570 GT":
                        Toast.makeText(getApplicationContext(),"Not yet implemented", Toast.LENGTH_LONG).show();
                        break;
                    case "540C":
                        Toast.makeText(getApplicationContext(),"Not yet implemented", Toast.LENGTH_LONG).show();
                        break;
                }

                return true;

            }
        });
    }

    // Private section that is created to store the child elements of the menu
    // This gets called throughout and is custom made where this isnt an inbuilt function
    private void loadChild(String[] ParentElementsName){
        ChildList = new ArrayList<String>();
        for (String model : ParentElementsName)
            ChildList.add(model);
    }
}
