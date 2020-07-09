from unittest import TestCase

from xunit import TestCase, WasRun


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


TestTestCase("test_run").run()
TestTestCase("test_result").run()
TestTestCase("test_failed").run()
