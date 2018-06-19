import com.erg.abst.cpaar.prepare.IParserStarter;
import com.erg.cpaar.data.Option;
import com.erg.cpaar.data.Outputs;
import com.erg.cpaar.prepare.ParseStarter;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;


public class main {


    public static void main(String[] args) throws Exception {

        IParserStarter ps = new ParseStarter();
        ps.addOption("-s",Integer.class,true)
                .submit("SensorId")
                .addOption("-f",String.class,true)
                .submit("FilePaths")
                .addFlag("-imp")
                .submit("IsMapReduce")
                .addOption("-sid",String.class,false)
                .submit("ServerIds")
                .parse(args);

        LinkedHashMap<String ,?> asd = Outputs.flags;
        LinkedHashMap<String ,?> bsd = Outputs.options;
        List serverIds = Outputs.options.get("ServerIds");
        System.out.println("End");
    }
}

