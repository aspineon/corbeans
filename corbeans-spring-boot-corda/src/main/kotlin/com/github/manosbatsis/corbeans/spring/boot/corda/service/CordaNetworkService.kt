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
package com.github.manosbatsis.corbeans.spring.boot.corda.service

import com.github.manosbatsis.corbeans.spring.boot.corda.model.info.NetworkInfo
import com.github.manosbatsis.corbeans.spring.boot.corda.model.info.NodeInfo
import java.util.*

/**
 *  Corda network service
 */
interface CordaNetworkService {

    /** Node services by configured name */
    var nodeServices: Map<String, CordaNodeService>

    /**
     * Get information about known node network(s) and configuration
     */
    fun getInfo(): NetworkInfo

    /**
     * Get a Node service by name. Default is either the only node name if single,
     * or `cordform` based on node.conf otherwise
     */
    fun getNodeService(optionalNodeName: Optional<String> = Optional.empty()): CordaNodeService

    /**
     * Get a Node service by name. Default is either the only node name if single,
     * or `cordform` based on node.conf otherwise
     */
    fun getNodeService(nodeName: String?): CordaNodeService

    fun getNodesInfo(): Map<String, NodeInfo>
}
