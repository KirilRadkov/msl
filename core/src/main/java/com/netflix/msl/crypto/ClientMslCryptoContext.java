/**
 * Copyright (c) 2013-2014 Netflix, Inc.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.msl.crypto;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderFactory;
import com.netflix.msl.io.MslEncoderFormat;

/**
 * This class should be used by trusted network clients for the primary crypto
 * context used for master tokens and user ID tokens. It always fails to verify
 * and its other operations are no-ops.
 *
 * @author Wesley Miaw <wmiaw@netflix.com>
 * @see com.netflix.msl.util.MslContext#getMslCryptoContext()
 */
public class ClientMslCryptoContext implements ICryptoContext {
    /* (non-Javadoc)
     * @see com.netflix.msl.crypto.ICryptoContext#encrypt(byte[], com.netflix.msl.io.MslEncoderFactory, com.netflix.msl.io.MslEncoderFormat)
     */
    @Override
    public byte[] encrypt(final byte[] data, final MslEncoderFactory encoder, final MslEncoderFormat format) throws MslCryptoException {
        return data;
    }

    /* (non-Javadoc)
     * @see com.netflix.msl.crypto.ICryptoContext#decrypt(byte[], com.netflix.msl.io.MslEncoderFactory)
     */
    @Override
    public byte[] decrypt(final byte[] data, final MslEncoderFactory encoder) throws MslCryptoException {
        return data;
    }

    /* (non-Javadoc)
     * @see com.netflix.msl.crypto.ICryptoContext#wrap(byte[], com.netflix.msl.io.MslEncoderFactory, com.netflix.msl.io.MslEncoderFormat)
     */
    @Override
    public byte[] wrap(final byte[] data, final MslEncoderFactory encoder, final MslEncoderFormat format) throws MslCryptoException {
        // This should never be called.
        throw new MslInternalException("Wrap is unsupported by the MSL token crypto context.");
    }

    /* (non-Javadoc)
     * @see com.netflix.msl.crypto.ICryptoContext#unwrap(byte[], com.netflix.msl.io.MslEncoderFactory)
     */
    @Override
    public byte[] unwrap(final byte[] data, final MslEncoderFactory encoder) throws MslCryptoException {
        // This should never be called.
        throw new MslInternalException("Unwrap is unsupported by the MSL token crypto context.");
    }

    /* (non-Javadoc)
     * @see com.netflix.msl.crypto.ICryptoContext#sign(byte[], com.netflix.msl.io.MslEncoderFactory, com.netflix.msl.io.MslEncoderFormat)
     */
    @Override
    public byte[] sign(final byte[] data, final MslEncoderFactory encoder, final MslEncoderFormat format) throws MslCryptoException {
        return new byte[0];
    }

    /* (non-Javadoc)
     * @see com.netflix.msl.crypto.ICryptoContext#verify(byte[], byte[], com.netflix.msl.io.MslEncoderFactory)
     */
    @Override
    public boolean verify(final byte[] data, final byte[] signature, final MslEncoderFactory encoder) throws MslCryptoException {
        return false;
    }
}
