# Extractor

## logic of the extraction of the Protocol, Domain and Path from an URL in this project

### inside the unapply method:
  1. unapply method will take an argument of type Extractor which has a field "url", and it will return 
     Option[(String, String, String)]
     
  2. the variable 'listOfStringsForHelp' will hold an list of non-empty Strings splited by "/"  
     for example: 
        url = "https://github.com/jitendra2329"
        listOfsStringsForHelp = List("https:", "github.com", "jitendra2329")
        
  3. the variable tupleOfStrings will hold a tuple2, splited by splitAt method, which will split the url 
     from a given index (length of string at index 0 + length of string at index 1 + 3 in listOfStringsForHelp)
     in this case, ("https".length + "github.com".length + 3) = 16, So splitAt method will spilt the utl from 
     16th index into two part
     
  4. then in the finalListOfStrings, we will take first non-empty string from the tupleOfString and split that with "/"
  
  5. then we wiil take first String from the final list and will take the string by droping last character of it
     will pass it as fist parameter in Some
     
  6. will take the second parameter of the finalListOfStrings and pass it to Some as secome parameter
  
  7. we will pass second string of tupleOfString as third parameter of Some
  
Rest of the code of this file  is self understandable, Taking the URL and the Validating it and the extracting it
by pattern matching
