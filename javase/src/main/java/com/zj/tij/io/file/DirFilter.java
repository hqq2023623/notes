package com.zj.tij.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 文件名过滤器
 *
 * @author Lzj Created on 2015/12/18.
 */
public class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }


    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }


}
