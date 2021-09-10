package brudingiton.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasteCod {
    private final List<String> textCodes = new ArrayList<>(Arrays.asList(
            "git config --global user.name \"New Sheriff in Town\"",
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")",
            "git push origin master --force")
    );

    private final String titleName = "how to gain dominance among developers";
    private final String textBash = "Bash";

    private final List<String> commandsGitBash = new ArrayList<>(Arrays.asList(
            "git config",
            "git reset",
            "git commit-tree",
            "git push",
            "tree")
    );

    private final List<String> characterBashWrap = new ArrayList<>(Arrays.asList(
            "(",
            ")",
            "{",
            "}")
    );

    public List<String> getCommandsGitBash() {
        return commandsGitBash;
    }

    public List<String> getCharacterBashWrap() {
        return characterBashWrap;
    }

    public List<String> getTextCodes() {
        return textCodes;
    }

    public String getTitleName(){
        return titleName;
    }

    public String getTextBash(){
        return textBash;
    }

}