package com.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ted.model.Category;
import com.ted.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
		
	}

	public String getMenuHtml() {
		
		String html = "";
		
		List<Category> categories = categoryRepository.getTopCategories();
		
		for(Category category : categories) {
			
			/* Top Categories start */
			html += "<li class=\"dropdown mega-dropdown\">\r\n                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">"
					+ category.getName()
					+ "<span class=\"caret\"></span></a>\r\n                        <ul class=\"dropdown-menu mega-dropdown-menu\">\r\n                            <li class=\"col-sm-3\">\r\n                                <ul>\r\n                                    <li class=\"dropdown-header\">Recent Auctions</li>\r\n                                    <div id=\"recentAuctions\" class=\"carousel slide\" data-ride=\"carousel\">\r\n                                      <div class=\"carousel-inner\">\r\n                                        <div class=\"item active\">\r\n                                            <a href=\"#\"><img src=\"http://placehold.it/254x150/ff3546/f5f5f5/&text=New+Collection\" class=\"img-responsive\" alt=\"product 1\"></a>\r\n                                            <h4><small>Summer dress floral prints</small></h4>\r\n                                            <button class=\"btn btn-primary\" type=\"button\">49,99 &euro;</button> <button href=\"#\" class=\"btn btn-default\" type=\"button\">See more here</button>\r\n                                        </div><!-- End Item -->\r\n                                        <div class=\"item\">\r\n                                            <a href=\"#\"><img src=\"http://placehold.it/254x150/3498db/f5f5f5/&text=New+Collection\" class=\"img-responsive\" alt=\"product 2\"></a>\r\n                                            <h4><small>Gold sandals with shiny touch</small></h4>\r\n                                            <button class=\"btn btn-primary\" type=\"button\">9,99 &euro;</button> <button href=\"#\" class=\"btn btn-default\" type=\"button\">See more here</button>\r\n                                        </div><!-- End Item -->\r\n                                        <div class=\"item\">\r\n                                            <a href=\"#\"><img src=\"http://placehold.it/254x150/2ecc71/f5f5f5/&text=New+Collection\" class=\"img-responsive\" alt=\"product 3\"></a>\r\n                                            <h4><small>Denin jacket stamped</small></h4>\r\n                                            <button class=\"btn btn-primary\" type=\"button\">49,99 &euro;</button> <button href=\"#\" class=\"btn btn-default\" type=\"button\">See more here</button>\r\n                                        </div><!-- End Item -->\r\n                                      </div><!-- End Carousel Inner -->\r\n                                      <!-- Controls -->\r\n                                      <a class=\"left carousel-control\" href=\"#recentAuctions\" role=\"button\" data-slide=\"prev\">\r\n                                        <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n                                        <span class=\"sr-only\">Previous</span>\r\n                                      </a>\r\n                                      <a class=\"right carousel-control\" href=\"#recentAuctions\" role=\"button\" data-slide=\"next\">\r\n                                        <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n                                        <span class=\"sr-only\">Next</span>\r\n                                      </a>\r\n                                    </div><!-- /.carousel -->\r\n                                    <li class=\"divider\"></li>\r\n                                    <li><a href=\"#\">View all Auctions <span class=\"glyphicon glyphicon-chevron-right pull-right\"></span></a></li>\r\n                                </ul>\r\n                            </li>\r\n                            <div class=\"col-9 pre-scrollabler\">";
			
			
			List<Category> categories2 = category.getCategories();
			
			Integer row = 4;							// Every fourth category add row div
			Integer div = 0;							// Every fourth category add </div>
			for(Category category2 : categories2) {
				
				/* Add row every 4 categories */
				if(row == 4) {
					html += "<div class=\"row\">";
					row = 0;
				}
				
				/* Second Category Start HTML */
				html += "<li class=\"col-sm-3\"><ul>"
						+"<li class=\"dropdown-header\">"
						+ category2.getName()
						+"</li>";
				
				
				List<Category> categories3 = category2.getCategories();
				
				for(Category category3 : categories3) {
					
					/* Third Category HTML */
					html += "<li><a href=\"#\">"
							+category3.getName()
							+"</a></li>";
					
				}
				
				/* Second Category End HTML */
				html += "</ul>\r\n                                    </li>";
				
				/* Close row every 4 categories */
				if(div == 4) {
					html += "</div>";
					div = 0;
				}
				
				row++;
				div++;
			}
			
			/* Top Categories End */
			html += "</div>\r\n                     </div>\r\n                  </ul>\r\n               </li>";
					
		}
		
		return html;
		
	}
	

}
