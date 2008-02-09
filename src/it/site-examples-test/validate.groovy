// Verify behavior report
behaviorReport = new File('src/it/site-examples-test/target/easyb/report.xml')
assert behaviorReport.exists()

def results = new XmlParser().parse(behaviorReport)
assert '21' == results.'@totalrun'
assert '0' == results.'@totalfailed'

// Verify story printing
storyReport = new File('src/it/site-examples-test/target/easyb/stories.txt')
assert storyReport.text ==
'''21 behavior steps executed successfully  
  Story: empty stack
    scenario null is pushed onto empty stack
      given an empty stack
      when null is pushed
      then an exception should be thrown
      then the stack should still be empty
    scenario pop is called on empty stack
      given an empty stack
      when pop is called
      then an exception should be thrown
      then the stack should still be empty
  Story: single value stack
    scenario pop is called
      given a stack containing an item
      when peek is called
      then it should provide the value of the most recent pushed value
      then the stack should not be empty
      then calling pop should also return the peeked value
      then the stack should be empty
'''