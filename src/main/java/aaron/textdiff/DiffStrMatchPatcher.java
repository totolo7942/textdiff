package aaron.textdiff;

import external.library.google.diff_match_patch;

import java.util.LinkedList;

public class DiffStrMatchPatcher {
    public static void main(String[] args) {
        final String org = "hello world";
        final String vine = "good world";

        diff_match_patch dmp = new diff_match_patch();
        LinkedList<diff_match_patch.Diff> diff = dmp.diff_main(org, vine);
        dmp.diff_cleanupSemantic(diff);
        for (diff_match_patch.Diff diff2 : diff) {
            if( diff2.operation != diff2.operation.EQUAL)
                System.out.print("[" + diff2.text+ "]") ;
            else
                System.out.println(diff2.text);
        }


        LinkedList<diff_match_patch.Diff> diff1 = dmp.diff_main("Hello World", "Goodbye World");
        dmp.diff_cleanupSemantic(diff1);

    }
}
