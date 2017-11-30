/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.coyote.http11.filters;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.apache.coyote.OutputBuffer;
import org.apache.coyote.Response;
import org.apache.coyote.http11.OutputFilter;
import org.apache.tomcat.util.buf.ByteChunk;

/**
 * Void output filter, which silently swallows bytes written. Used with a 204
 * status (no content) or a HEAD request.
 *
 * @author Remy Maucherat
 */
public class VoidOutputFilter implements OutputFilter {

    // --------------------------------------------------- OutputBuffer Methods

    /**
     * @deprecated Unused. Will be removed in Tomcat 9. Use
     *             {@link #doWrite(ByteBuffer)}
     */
    @Deprecated
    @Override
    public int doWrite(ByteChunk chunk) throws IOException {
        return chunk.getLength();
    }


    @Override
    public int doWrite(ByteBuffer chunk) throws IOException {
        return chunk.remaining();
    }


    @Override
    public long getBytesWritten() {
        return 0;
    }


    // --------------------------------------------------- OutputFilter Methods

    @Override
    public void setResponse(Response response) {
        // NOOP: No need for parameters from response in this filter
    }


    @Override
    public void setBuffer(OutputBuffer buffer) {
        // NO-OP
    }


    @Override
    public void recycle() {
        // NOOP: Nothing to recycle
    }


    @Override
    public void  end() throws IOException {
        // NO-OP
    }
}
