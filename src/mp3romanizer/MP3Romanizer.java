/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3romanizer;

import Translation.Languages;
import Translation.Translation;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.iharder.dnd.FileDrop;

/**
 *
 * @author Tami
 */
public class MP3Romanizer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.farng.mp3.TagException
     */
    static boolean test = false;

    public static void main(String[] args) throws IOException,
            Exception, NullPointerException {
        // Stores relevant metadata to be manipulated
        JFrame jf = new JFrame("Localizer");
        JPanel jp = new JPanel();
        jf.add(jp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 400);
        jf.setVisible(true);

     

        List<String> tag_data = new ArrayList<>();

        String Mp3Path = "F:\\Music\\REDЯUM\\審美眼とパラドックス。\\06 紅く光る。.mp3";
        Mp3File asMp3 = new Mp3File(Mp3Path);
        ID3v2 tag = asMp3.getId3v2Tag();

        // Collecting the subfields of the tag to be translated
        tag_data.add(tag.getTitle());
        tag_data.add(tag.getAlbum());
        tag_data.add(tag.getArtist());
        tag_data.add(tag.getAlbumArtist());

        List<String> orig = new ArrayList<>(tag_data);
        Iterator itr = tag_data.listIterator(0);
//        while (itr.hasNext()){
//            Object element = itr.next();
//            System.out.println(element + " ");
//        }
        Languages.listString();

        int it = 0;
        while (itr.hasNext()) {
            Object ele = itr.next();
            Translation t = new Translation();
            t.text((String) ele);
            URL cur = t.primeLink(Languages.English);
            ele = t.fromWebsite(cur);
            tag_data.set(it, (String) ele);
            if (test) {
                System.out.println(tag_data.get(it));
            }
            it++;
        }
        // Comparison message
        if (orig.toString().equalsIgnoreCase(tag_data.toString())) {
            System.out.println("You are converting to the same language!!!");
        } else {
            System.out.println("Would you like to change to new data from \n" + orig.toString() + " to\n" + tag_data.toString());
            Scanner input = new Scanner(System.in);
            if (input.nextLine().equalsIgnoreCase("yes")) {
                // Apply changes to tag data
                tag.setTitle(tag_data.get(0));
                tag.setAlbum(tag_data.get(1));
                tag.setArtist(tag_data.get(2));
                tag.setAlbumArtist(tag_data.get(3));
                File newmp3 = new File(tag_data.get(0) + ".mp3");
                newmp3.createNewFile();
                // create copy of localized song
                asMp3.save(tag_data.get(0) + ".mp3");
            } else {
                System.out.println("GOOD BYE!");
            }
        }

    }

}
