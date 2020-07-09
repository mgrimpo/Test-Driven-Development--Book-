from unittest import TestCase

from xunit import TestCase, WasRun


class TestTestCase(TestCase):
    def setUp(self):
        self.test = WasRun("testMethod")

    def test_run(self):
        assert (not self.test.wasRun)
        self.test.run()
        assert self.test.wasRun

    def test_setUp(self):
        self.test.run()
        assert self.test.wasSetUp


TestTestCase("test_run").run()
TestTestCase("test_setUp").run()
