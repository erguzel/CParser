import com.erg.cpaar.CmdFlag;
import com.erg.cpaar.CmdOption;
import com.erg.cpaar.ParserStarter;

import java.util.List;
import java.util.Map;


public class main {


    public static void main(String[] args) throws Exception {

        new ParserStarter()
                .AddFlag(new CmdFlag("IsSaveMode","-sv",false))
                .AddOption(new CmdOption("InputFiles","-f",String.class,true))
                .AddOption(new CmdOption("OutDir","-out",String.class,false))
                .AddFlag(new CmdFlag("IsHelp","-help",false))
                .AddFlag(new CmdFlag("IsVerbose","-v",false))
                .AddFlag(new CmdFlag("IsCredentials","-a",false))
                .Parse(args);


        Map<Object,Boolean> asdasd =    ParserStarter.ParsedOutputs.CmdFlags;
        Map<Object,List<Object>> objectList= ParserStarter.ParsedOutputs.CmdOptions;
        Map<Object,List<Object>> objectListMap = ParserStarter.ParsedOutputs.CmdKeyValuePairs;

    }
}

