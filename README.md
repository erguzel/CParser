###INTRODUCTION

cpaar is a generic command line parsing tool for java applications. 

### How to use

Reference cpaar to your gradle project after adding jitpack repository as

```
allprojects{
    repositories {
        jcenter()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
}
dependencies {
    compile 'com.github.erguzel:cpaar:master-SNAPSHOT'
}
```

In the main application, use ParserStarter as giving arguments as parameter;

```
 new ParserStarter()
            .AddOption(new CmdOption("NumberOfPlayers","-np",Integer.class,false))
               .AddFlag(new CmdFlag("IsStatistics","-st",false))
                .Parse(args);
```

Parsed parameters will be in the Map<Object, List<Object>> object as key name is the name you defined as CmdArgument name as ;

```
String numberofplayers = ParserStarter.ParsedOutputs.CmdOptions.get("NumberOfPlayers").get(0).toString()
```

