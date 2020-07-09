from unittest import TestCase

from xunit import TestCase, WasRun


class TestTestCase(TestCase):
    def test_run(self):
        test = WasRun("testMethod")
        test.run()
        assert test.log == "setUp testMethod tearDown "


TestTestCase("test_run").run()
