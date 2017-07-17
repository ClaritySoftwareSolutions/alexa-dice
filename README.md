[![Build Status](https://travis-ci.org/ClaritySoftwareSolutions/alexa-skills-dice.svg?branch=master)](https://travis-ci.org/ClaritySoftwareSolutions/alexa-skills-dice)

----
# alexa-skills-dice
### Basic Amazon Alexa Skill lambda written in Java to perform dice rolling for board games
Alexa Skills can be configured to invoke either a lambda or a web service.  Whilst there are already several similar Alexa Skills available (dice rolling), this project serves as a simple example of how to write an AWS lambda for an Alexa Skill.

##### This Project
In order to produce a clean simple example, this project uses only Amazon Alexa and Lambda compile dependencies. Because of this, there are no dependency injection or IOC patterns in use, meaning that some classes are new'ed up inline where ordinarily one might choose to inject them.  
The purpose of this project is to provide a simple example of a Amazon Alexa Skill Lambda, rather than a production ready artifact.

#### Basic Process
The Alexa Skill can be configured to invoke a lambda to perform the skill action.
* For a java lambda, Alexa will instantiate the configured [SpeechletRequestStreamHandler](https://developer.amazon.com/public/binaries/content/assets/javadoc/ask-java-library-3/com/amazon/speech/speechlet/lambda/SpeechletRequestStreamHandler.html). 
* The default no-arg constructor calls the superclass constructor, passing in an implementation of [SpeechletV2](https://developer.amazon.com/public/binaries/content/assets/javadoc/ask-java-library-3/com/amazon/speech/speechlet/Speechlet.html) and the supported application ids.
* The `SpeechletV2` implements the lifecycle methods `onLauch` and `onIntent`, returning instances of [SpeechletResponse](https://developer.amazon.com/public/binaries/content/assets/javadoc/ask-java-library-3/com/amazon/speech/speechlet/speechletresponse.html).

#### Core Classes
##### DiceRequestStreamHandler
`DiceRequestStreamHandler` is the implementation of `SpeechletRequestStreamHandler`.
* The supported application ids are resolved from the system environment variable `com.amazon.speech.speechlet.servlet.supportedApplicationIds`, preventing them being hardcoded.
* `DiceSpeechlet` (the instance of `SpeechletV2`) is simply new'ed up inline.

##### DiceSpeechlet
`DiceSpeechlet` is the implementation of `SpeechletV2`.
* `onIntent` maps the intent name of the [IntentRequest](https://developer.amazon.com/public/binaries/content/assets/javadoc/ask-java-library-3/com/amazon/speech/speechlet/IntentRequest.html) to an `IntentHandler` and calls it's `handleIntent` method.
* `onLaunch` calls the `handleIntent` method of the `ROLL_DICE_INTENT` `IntentHandler`.

##### IntentHandler
`IntentHandler` is an interface whose implementations handle one specific intent.
* `RollDiceIntentHander` is resposible for rolling the dice and generating a `SpeechletResponse` describing the dice value.
* `HelpIntentHandler` is responsible for generating a `SpeechletResponse` containing help.

----
Copyright &copy; 2017 [Clarity Software Solutions Limited](https://claritysoftware.co.uk)

