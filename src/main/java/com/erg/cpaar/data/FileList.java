package com.erg.cpaar.data;

import com.erg.abst.cpaar.data.raw.IFileList;
import com.erg.abst.enm.ExtensionTypes;

public class FileList implements IFileList {

    private ExtensionTypes _extensionType;
    public FileList(ExtensionTypes extensionType) {
        _extensionType = extensionType;
    }

    @Override
    public ExtensionTypes getExtensionType() {
        return _extensionType;
    }

    @Override
    public void setExtensionType(ExtensionTypes extensionType) {
        _extensionType = extensionType;
    }
}
