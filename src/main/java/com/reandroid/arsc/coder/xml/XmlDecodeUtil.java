/*
 *  Copyright (C) 2022 github.com/REAndroid
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reandroid.arsc.coder.xml;

import org.xmlpull.v1.XmlSerializers;

import java.io.IOException;

public class XmlDecodeUtil {

    public static void rootIndent(XmlSerializers serializer) throws IOException {
        writeTagIndent(serializer, INDENT_ROOT);
    }
    public static void bagIndent(XmlSerializers serializer) throws IOException {
        writeTagIndent(serializer, INDENT_BAG);
    }
    public static void entryIndent(XmlSerializers serializer) throws IOException {
        writeTagIndent(serializer, INDENT_ENTRY);
    }
    public static void writeTagIndent(XmlSerializers serializer, int level) throws IOException {
        if(level < 0){
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append('\n');
        for(int i = 0; i < level; i++){
            builder.append(' ');
        }
        serializer.text(builder.toString());
    }
    static final int INDENT_ROOT = 0;
    static final int INDENT_ENTRY = 2;
    static final int INDENT_BAG = 4;
}
