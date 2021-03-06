/*
 *     Corbeans: Corda integration for Spring Boot
 *     Copyright (C) 2018 Manos Batsis
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 3 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 */
package com.github.manosbatsis.corbeans.spring.boot.corda.model.upload

import java.io.Closeable
import java.io.File
import java.io.InputStream

/** Data transfer object representing an attachment to be persisted in the vault */
data class Attachment(
        /** The temporary file backing this attachment, if any */
        val tmpFile: File? = null,
        /** The attachment input stream to upload */
        val inputStream: InputStream,
        /** The files contained in the attachment archive */
        val filenames: List<String>,
        /** `true` if an archive as originally uploaded,
         * `false` if automatically created to save in the vault  */
        val original: Boolean = false
): Closeable {
        override fun close() {
                // Delete tmp file if it exists
                if(tmpFile != null && tmpFile.exists()) tmpFile.delete()
        }
}