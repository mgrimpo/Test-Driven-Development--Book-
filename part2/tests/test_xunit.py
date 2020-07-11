from xunit import TestCase, WasRun, TestResult, TestSuite


class TestTestCase(TestCase):
    def test_run(self):
        test = WasRun("testMethod")
        test.run()
        assert test.log == "setUp testMethod tearDown "

    def test_result(self):
        test = WasRun("testMethod")
        result = test.run()
        assert "1 run, 0 failed" == result.summary()

    def test_failed(self):
        test = WasRun("brokenMethod")
        result = test.run()
        assert "1 run, 1 failed" == result.summary()

    def test_failed_result_formatting(self):
        result = TestResult()
        result.testStarted()
        result.testFailed()
        assert "1 run, 1 failed"

    def test_suite(self):
        suite = TestSuite()
        suite.add(WasRun("testMethod"))
        suite.add(WasRun("brokenMethod"))
        result = suite.run()
        assert result.summary() == "2 run, 1 failed"

    def test_add_result(self):
        result1 = TestResult()
        result2 = TestResult()
        result1.testStarted()
        result1.testFailed()
        result2.testStarted()
        combined_result = result1.add(result2)
        assert "2 run, 1 failed" == combined_result.summary()


suite = TestSuite()
suite.add(TestTestCase("test_run"))
suite.add(TestTestCase("test_result"))
suite.add(TestTestCase("test_failed"))
suite.add(TestTestCase("test_failed_result_formatting"))
suite.add(TestTestCase("test_suite"))
suite.add(TestTestCase("test_add_result"))
result = suite.run()
print(result.summary())
