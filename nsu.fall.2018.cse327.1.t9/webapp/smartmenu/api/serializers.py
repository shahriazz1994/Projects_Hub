from rest_framework import serializers
from food.models import FoodCategory, FoodDetails


class FoodCategorySerializer(serializers.ModelSerializer):
    class Meta:
        model = FoodCategory
        fields = ['id', 'categoryname', 'categorydetails', 'categoryimage', 'url']


class FoodDetailSerializer(serializers.ModelSerializer):
    class Meta:
        model = FoodDetails
        fields = ['id', 'fromcategory', 'foodname', 'fooddetails', 'foodimage', 'armodel', 'additiondate','longdetails', 'url']
