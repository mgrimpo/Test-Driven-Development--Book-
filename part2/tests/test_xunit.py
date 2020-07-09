from unittest import TestCase

from xunit import TestCase, WasRun, TestResult


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


tests = [
    TestTestCase("test_run"),
    TestTestCase("test_result"),
    TestTestCase("test_failed"),
    TestTestCase("test_failed_result_formatting")
]
for test in tests:
    print(test.name + ":")
    print(test.run().summary())
