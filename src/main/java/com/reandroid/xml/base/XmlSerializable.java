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
package com.reandroid.xml.base;

import com.reandroid.xml.XMLFactory;
import com.reandroid.xml.XMLUtil;
import com.reandroid.xml.XmlIndentingSerializers;
import org.xmlpull.v1.XmlSerializers;

import java.io.IOException;
import java.io.StringWriter;

public interface XmlSerializable {

    void serialize(XmlSerializers serializer) throws IOException;

    static String toXmlString(XmlSerializable serializable, boolean indent) throws IOException {
        StringWriter stringWriter = new StringWriter();
        XmlSerializers serializer = XMLFactory.newSerializer(stringWriter);
        if(indent) {
            serializer = XmlIndentingSerializers.create(serializer);
        }
        serializable.serialize(serializer);
        XMLUtil.close(serializer);
        stringWriter.close();
        return stringWriter.toString();
    }
}