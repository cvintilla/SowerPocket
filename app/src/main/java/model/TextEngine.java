package model;

import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by bccenten on 11/1/2017.
 */

public class TextEngine {


//    public List<Outlet> executeTextCommand(String text, List<Outlet> outlets) {
//
//        String command = text.toUpperCase();
//        List<String> wordList = new ArrayList<>();
//
//        StringTokenizer st = new StringTokenizer(command);
//
//        while(st.hasMoreTokens()){
//            wordList.add(st.nextToken());
//        }
//
//
//        if (wordList.contains("ON")) {
//
//            if (command.contains("1") || command.contains("ONE")) {
//                outlets.get(0).setOutlet_status(true);
//            } else if (command.contains("2") || command.contains("TWO")) {
//                outlets.get(1).setOutlet_status(true);
//
//            } else if (command.contains("3") || command.contains("THREE")) {
//                outlets.get(2).setOutlet_status(true);
//
//            } else if (command.contains("4") || command.contains("FOUR")) {
//                outlets.get(3).setOutlet_status(true);
//
//            } else if (command.contains("5") || command.contains("FIVE")) {
//                outlets.get(4).setOutlet_status(true);
//
//            } else if (command.contains("6") || command.contains("SIX")) {
//                outlets.get(5).setOutlet_status(true);
//            } else {
//
//            }
//
//        } else if (command.contains("OFF")) {
//            if (command.contains("1") || command.contains("ONE")) {
//                outlets.get(0).setOutlet_status(false);
//            } else if (command.contains("2") || command.contains("TWO")) {
//                outlets.get(1).setOutlet_status(false);
//
//            } else if (command.contains("3") || command.contains("THREE")) {
//                outlets.get(2).setOutlet_status(false);
//
//            } else if (command.contains("4") || command.contains("FOUR")) {
//                outlets.get(3).setOutlet_status(false);
//
//            } else if (command.contains("5") || command.contains("FIVE")) {
//                outlets.get(4).setOutlet_status(false);
//
//            } else if (command.contains("6") || command.contains("SIX")) {
//                outlets.get(5).setOutlet_status(false);
//
//            } else {
//
//            }
//        }
//
//        return outlets;
//    }

    public void executeTextCommand(String text, List<Switch> mySwitchList) {

        String command = text.toUpperCase();
        RESTClient client = new RESTClient();

        List<String> wordList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(command);

        while(st.hasMoreTokens()){
            wordList.add(st.nextToken());
        }



        if (wordList.contains("ON")) {


            if (command.contains("1") || command.contains("ONE") || command.contains("WON") || command.contains("JUAN")) {
                client.outletToggleDirect(true, "1");
                mySwitchList.get(0).setChecked(true);
            } else if (command.contains("2") || command.contains("TWO") || command.contains("TO") || command.contains("TOO")) {
                client.outletToggleDirect(true, "2");
                mySwitchList.get(1).setChecked(true);

            } else if (command.contains("3") || command.contains("THREE")) {
                client.outletToggleDirect(true, "3");
                mySwitchList.get(2).setChecked(true);

            } else if (command.contains("4") || command.contains("FOUR") || command.contains("FOR") || command.contains("FORE")) {
                client.outletToggleDirect(true, "4");
                mySwitchList.get(3).setChecked(true);

            } else if (command.contains("5") || command.contains("FIVE")) {
                client.outletToggleDirect(true, "5");
                mySwitchList.get(4).setChecked(true);

            } else if (command.contains("6") || command.contains("SIX")) {
                client.outletToggleDirect(true, "6");
                mySwitchList.get(5).setChecked(true);

            } else {

            }


        } else if (command.contains("OFF")) {

            if (command.contains("1") || command.contains("ONE") || command.contains("WON") || command.contains("JUAN")) {
                client.outletToggleDirect(false, "1");
                mySwitchList.get(0).setChecked(false);

            } else if (command.contains("2") || command.contains("TWO") || command.contains("TO") || command.contains("TOO")) {
                client.outletToggleDirect(false, "2");
                mySwitchList.get(1).setChecked(false);


            } else if (command.contains("3") || command.contains("THREE")) {
                client.outletToggleDirect(false, "3");
                mySwitchList.get(2).setChecked(false);


            } else if (command.contains("4") || command.contains("FOUR") || command.contains("FOR") || command.contains("FORE")) {
                client.outletToggleDirect(false, "4");
                mySwitchList.get(3).setChecked(false);


            } else if (command.contains("5") || command.contains("FIVE")) {
                client.outletToggleDirect(false, "5");
                mySwitchList.get(4).setChecked(false);


            } else if (command.contains("6") || command.contains("SIX")) {
                client.outletToggleDirect(false, "6");
                mySwitchList.get(5).setChecked(false);


            } else {

            }
        }

    }

}