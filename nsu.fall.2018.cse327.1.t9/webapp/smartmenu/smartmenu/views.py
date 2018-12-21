from django.shortcuts import render
from food.models import FoodCategory


def home(request):
    details = FoodCategory.objects.all()
    context = {
        'details': details,
        'page_title': 'Home'
    }
    return render(request, 'smartmenu/base-home.html', context)
