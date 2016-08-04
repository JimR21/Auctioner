package com.ted;

import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.ted.model.Auction;
import com.ted.model.XmlAuctionWrapper;

public class XmlMarshalling {
	
//	@Autowired
//	XmlService xmlService;
	
	
	@Test
	public void auctionsUnmarshalling() {

		try {
			JAXBContext context = JAXBContext.newInstance(XmlAuctionWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			for(int j = 0; j < 1; j++) {
				
				XmlAuctionWrapper wrapper = (XmlAuctionWrapper)unmarshaller.unmarshal(new FileReader("D:\\ebay-data\\items-" + j + ".xml"));
				
				//xmlService.saveXmlAuction(wrapper.getAuctions());
				
				int i = 0;
				for(Auction auction : wrapper.getAuctions()) {
					System.out.println("File" + j + ": Auction" + i + ": " + auction.getName());
					i++;
				}
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

}
