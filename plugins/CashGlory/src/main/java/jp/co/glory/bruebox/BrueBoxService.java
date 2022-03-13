package jp.co.glory.bruebox;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "BrueBoxService", targetNamespace = "http://www.glory.co.jp/bruebox.wsdl", wsdlLocation = "file:/D:/_Docs/SCO/BrueBoxService.wsdl")
public class BrueBoxService
		extends Service
{

	public BrueBoxService(String address) throws MalformedURLException {
		super(new URL(address), new QName("http://www.glory.co.jp/bruebox.wsdl", "BrueBoxService"));
	}

	/**
	 * 
	 * @return
	 *         returns BrueBoxPortType
	 */
	@WebEndpoint(name = "BrueBoxPort")
	public BrueBoxPortType getBrueBoxPort() {
		return super.getPort(new QName("http://www.glory.co.jp/bruebox.wsdl", "BrueBoxPort"), BrueBoxPortType.class);
	}

	/**
	 * 
	 * @param features
	 *        A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter will
	 *        have their default values.
	 * @return
	 *         returns BrueBoxPortType
	 */
	@WebEndpoint(name = "BrueBoxPort")
	public BrueBoxPortType getBrueBoxPort(WebServiceFeature... features) {
		return super.getPort(new QName("http://www.glory.co.jp/bruebox.wsdl", "BrueBoxPort"), BrueBoxPortType.class, features);
	}

}
