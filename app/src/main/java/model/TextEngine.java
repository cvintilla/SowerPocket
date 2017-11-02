package model;

import java.util.List;

/**
 * Created by bccenten on 11/1/2017.
 */

public class TextEngine {


    public List<Outlet> executeTextCommand(String text, List<Outlet> outlets) {

        String command = text.toUpperCase();

        if (command.contains("ON")) {

            if (command.contains("1") || command.contains("ONE")) {
                outlets.get(0).setOutlet_status(true);
            } else if (command.contains("2") || command.contains("TWO")) {
                outlets.get(1).setOutlet_status(true);

            } else if (command.contains("3") || command.contains("THREE")) {
                outlets.get(2).setOutlet_status(true);

            } else if (command.contains("4") || command.contains("FOUR")) {
                outlets.get(3).setOutlet_status(true);

            } else if (command.contains("5") || command.contains("FIVE")) {
                outlets.get(4).setOutlet_status(true);

            } else if (command.contains("6") || command.contains("SIX")) {
                outlets.get(5).setOutlet_status(true);
            } else {

            }

        } else if (command.contains("OFF")) {
            if (command.contains("1") || command.contains("ONE")) {
                outlets.get(0).setOutlet_status(false);
            } else if (command.contains("2") || command.contains("TWO")) {
                outlets.get(1).setOutlet_status(false);

            } else if (command.contains("3") || command.contains("THREE")) {
                outlets.get(2).setOutlet_status(false);

            } else if (command.contains("4") || command.contains("FOUR")) {
                outlets.get(3).setOutlet_status(false);

            } else if (command.contains("5") || command.contains("FIVE")) {
                outlets.get(4).setOutlet_status(false);

            } else if (command.contains("6") || command.contains("SIX")) {
                outlets.get(5).setOutlet_status(false);

            } else {

            }
        }

        return outlets;
    }

}