package com.erg.cpaar.operate;

import com.erg.abst.cpaar.data.raw.IFileList;
import com.erg.abst.global.IExecutable;

public class FileListParser implements IExecutable {

    private IFileList _filelist;

    public FileListParser(IFileList filelist) {
        _filelist = filelist;
    }

    @Override
    public void execute() throws Exception {
        throw new Exception("Not implemented yet");
    }
}
