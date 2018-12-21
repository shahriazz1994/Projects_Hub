from django.test import TestCase
from .models import FoodCategory, FoodDetails
from django.utils import timezone


# Create your tests here.

class CategoryTest(TestCase):
    def create_category(self, title='test name', detail='blah blah'):
        return FoodCategory.objects.create(categoryname=title,
                                           categorydetails=detail)

    def test_category_creation(self):
        a = self.create_category()
        self.assertTrue(isinstance(a, FoodCategory))
        self.assertEqual(a.__str__(), a.categoryname)


class ListTest(TestCase):
    a = FoodCategory.objects.get(pk=1)
    def create_list(self, title='test fname', detail='blah blah', long_detail='more bla bla bla', ar='some.sfb',id=a):
        return FoodDetails.objects.create(foodname=title,
                                          fooddetails=detail,
                                          longdetails=long_detail,
                                          armodel=ar,
                                          additiondate=timezone.now(),
                                          fromcategory=id
                                          )

    def test_category_creation(self):
        a = self.create_list()
        self.assertTrue(isinstance(a, FoodDetails))
        self.assertEqual(a.__str__(), a.foodname)
