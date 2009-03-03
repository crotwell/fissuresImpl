#!/bin/sh

javadoc -J-mx32m \
-sourcepath ob/src:ob/src/generated:naming/src:naming/src/generated:\
trading/src:trading/src/generated:event/src:event/src/generated:\
property/src:property/src/generated:util/src \
-d api \
org.omg.CORBA \
org.omg.CORBA_2_3 \
org.omg.PortableServer \
org.omg.BiDirPolicy \
org.omg.CONV_FRAME \
org.omg.Dynamic \
org.omg.DynamicAny \
org.omg.GIOP \
org.omg.IIOP \
org.omg.IOP \
org.omg.Messaging \
org.omg.PortableInterceptor \
org.omg.PortableServer.CurrentPackage \
org.omg.PortableServer.POAPackage \
org.omg.PortableServer.POAManagerPackage \
org.omg.CosNaming \
org.omg.CosNaming.NamingContextExtPackage \
org.omg.CosNaming.NamingContextPackage \
org.omg.CosTrading \
org.omg.CosTrading.AdminPackage \
org.omg.CosTrading.ProxyPackage \
org.omg.CosTrading.RegisterPackage \
org.omg.CosTrading.LinkPackage \
org.omg.CosTrading.LookupPackage \
org.omg.CosEventChannelAdmin \
org.omg.CosEventComm \
org.omg.CosTypedEventChannelAdmin \
org.omg.CosTypedEventComm \
org.omg.CosPropertyService  

