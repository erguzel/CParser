import com.erg.abst.cpaar.IParseStarter;
import com.erg.cpaar.starter.ParseStarter;

public class main {


    public static void main(String[] args){

        IParseStarter ps = new ParseStarter();
        ps.addOption("-as",Integer.class,true)
                .isMultipleValued(true)
                .submit("option2")
                .addOption("-bs",String.class,false)
                .isMultipleValued(false)
                .submit("option2")
                .parse(args);
    }
}

