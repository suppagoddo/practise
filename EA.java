import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by uagrawal on 11/30/16.
 */

// Find the unique number of players
// Create that many files
// For each player emit the 3 games based on timestamp into a file
//Change the base DIR

public class EA {
    static HashSet<String> players = new HashSet<String>();
    static String basedir = "/Users/uagrawal/selfcode/coderepo/";

    public static void main(String[] args) {
        //Read the initial file and output in file
        playerBasedFile(basedir + "input.txt");

        //For each player in players output the data into 3 games
        generateTriples();

        //For each game then store them in hashmap and return the final count HashMap
        finalCount(basedir + "games.txt");
    }

    public static class GameTS implements Comparable<GameTS> {
        String game;
        int ts;

        public GameTS(String game, int ts) {
            this.game = game;
            this.ts = ts;
        }

        @Override
        public int compareTo(GameTS o2) {
            return this.ts - o2.ts;
        }
    }

    public static void generateTriples() {
        for (String s: players) {
            //Read the data and sort is using the timestamp
            BufferedReader br = null;
            ArrayList<GameTS> glist = new ArrayList<GameTS>();
            try {
                String sCurrentLine;
                br = new BufferedReader(new FileReader(basedir + s.trim().toLowerCase() + ".txt"));
                while ((sCurrentLine = br.readLine()) != null) {
                    String str = sCurrentLine.trim();
                    String[] strArray = str.split(",");
                    GameTS gameTS = new GameTS(strArray[0], Integer.parseInt(strArray[1]));
                    glist.add(gameTS);
                }
                br.close();
                Collections.sort(glist);
                //Print into games
                writeFileFinal(glist);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void writeFileFinal(ArrayList<GameTS> glist) {
        try {
            //String content = "This is the content to write into file";
            File file = new File(basedir + "games.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < glist.size(); i++) {
                for (int j = i + 1; j < glist.size(); j++) {
                    for (int k = j + 1; k < glist.size(); k++) {
                        //System.out.println(glist.get(i) + "," + glist.get(j)+ "," + glist.get(k));
                        bw.write(glist.get(i).game + "," + glist.get(j).game + "," + glist.get(k).game);
                        bw.newLine();
                    }
                }
            }
            bw.close();
            //System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public static void playerBasedFile(String s) {
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(s));
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                String[] str = sCurrentLine.split(" ");

                if (!players.contains(str[0].trim().toLowerCase())) {
                    players.add(str[0].trim().toLowerCase());
                    //create the file and output the data
                    File file = new File(basedir + str[0].trim().toLowerCase() + ".txt");
                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(str[1].trim().toLowerCase() + ","  + str[2].trim().toLowerCase());
                    bw.newLine();
                    //System.out.println(str[1].trim().toLowerCase() + "," + str[2].trim().toLowerCase());
                    bw.close();
                } else {
                    //output the data in file
                    File file = new File(basedir + str[0].trim().toLowerCase() + ".txt");
                    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(str[1].trim().toLowerCase() + "," + str[2].trim().toLowerCase());
                    //System.out.println(str[1].trim().toLowerCase() + "," + str[2].trim().toLowerCase());
                    bw.newLine();
                    bw.close();
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void finalCount(String s) {
        BufferedReader br = null;
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(s));
            while ((sCurrentLine = br.readLine()) != null) {
                if (countMap.containsKey(sCurrentLine.trim().toLowerCase())) {
                    int count  = countMap.get(sCurrentLine.trim().toLowerCase());
                    count++;
                    countMap.put(sCurrentLine.trim().toLowerCase(), count);
                } else {
                    countMap.put(sCurrentLine.trim().toLowerCase(), 1);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (String key : countMap.keySet()) {
            System.out.println("(" + key.toString() + ")" + "\t" + countMap.get(key));
        }
    }



    public static void readFile(String s) {
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(s));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
