public void verifyTitle(String expectedTitle) {
		
		if(expectedTitle.equalsIgnoreCase(getTitle())){
		System.out.println("Title has been verified successfully");
	}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		
		if(ele.getText().equalsIgnoreCase(expectedText)){
			System.out.println("Expected text is same as actual text");
			takeSnap();
		}
		
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)){
			System.out.println("Expected text is similiar to actual text");
			takeSnap();
		}	

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if(ele.getText().equalsIgnoreCase(value)){
			System.out.println("Attribute exactly verified");
		}
		else{
			System.out.println("Attribute not exactly expected");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(value).equals(attribute)){
			System.out.println("Attribute partially verified");
		}
		else{
			System.out.println("Attribute not expected");
		}

	}

	public void verifySelected(WebElement ele) {
		if(ele.isSelected()==ele.equals(getClass())){}
			System.out.println("Element "+ele+" selected successfully");
			
	}

	public void verifyDisplayed(WebElement ele) {
		System.out.println(ele.getText());
		System.out.println(ele.getTagName());
		System.out.println("Element verified successfully");
		takeSnap();
		}
		
		public void acceptAlert() {
		driver.switchTo().alert().accept();
		
		System.out.println("alert accepted succesfully");
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		System.out.println("alert dismissed succesfully");
	}