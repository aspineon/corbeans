---
layout: docs
title: "Changelog"
---

# Changelog

The following sections describe major changes per version 
and can be helpful with version upgrades.

## 0.22

- Deprecated `WithImplicitNetworkITin` favour of `CorbeansSpringExtension`
- Updated Corda platform to version 4.0

## 0.21

- Updated Corda platform and plugins to 4.0-RC07 and 4.0.40 respectively.

## 0.20

- Improved exception handling in `NodeRpcConnection` attempts
- Added support for `ClientRpcSslOptions` configuration per node in `application.properties` 

## 0.19

- Initial changelog
- Added Corda 4.0 as minimum required version  
- Added [template project](project-template.html)
- Added `corbeans.nodes.default.*` properties for global node defaults
- Added new config properties per node and `CordaRPCClientConfiguration` updates in Corda 4.0
- Added `CordaNetworkService` as a convenient, autowirable entry point to API
- Added `StateService` helpers 
- Removed `WithDriverNodesIT.getCordappPackages` 
and `WithImplicitNetworkIT.getCordappPackages` methods 
in favor of using `corbeans.cordapPackages` configuration in __application.properties__
- Added `CorbeansSpringExtension` for implicit network during integration tests as an alternative to subclassing `WithImplicitNetworkIT`
- Fixed `WithImplicitNetworkIT` issue with test hanging in some cases
- Moved REST controller endpoints from `/node` and `/nodes/{nodeName}` to 
`/api/node` and `/api/nodes/{nodeName}` respectively
- Refactored packages, for example 
	```kotlin
	import com.github.manosbatsis.corbeans.spring.boot.corda.util.NodeParams
	import com.github.manosbatsis.corbeans.spring.boot.corda.util.NodeRpcConnection
	import com.github.manosbatsis.corbeans.spring.boot.corda.CordaNodeService
	import com.github.manosbatsis.corbeans.spring.boot.corda.CordaNodeServiceImpl
	```
	is now
	```kotlin
	import com.github.manosbatsis.corbeans.spring.boot.corda.config.NodeParams
	import com.github.manosbatsis.corbeans.spring.boot.corda.rpc.NodeRpcConnection
	import com.github.manosbatsis.corbeans.spring.boot.corda.service.CordaNodeService
	import com.github.manosbatsis.corbeans.spring.boot.corda.service.CordaNodeServiceImpl
	```
- Refactored return type of `CordaNodeService.peers` and `CordaNodeService.peerNames` from 
`Map<String, List<String>>` to simply `List<String>`
- Added basic Spring boot Actuator components: an __info__ endpoint contributor and a custom 
__corda__ HTTP/JMX endpoint 
- Added endpoints for saving attachments and browsing attachment archive contents
- Added Spring converter for CordaX500Name
- Added ObjectMapper auto-configuration with RPC support
- CorbeansSpringExtension for JUnit5 now starts nodes and the container in the correct order

