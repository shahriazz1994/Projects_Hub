from food.models import FoodCategory, FoodDetails
from django.views.generic import ListView, DetailView, TemplateView
from django.shortcuts import render


class FoodCategoryView(ListView):
    model = FoodCategory
    template_name = 'food/food-category.html'
    context_object_name = 'category'


class FoodListView(ListView):
    model = FoodDetails
    template_name = 'food/food-list.html'
    context_object_name = 'food'

    ordering = ['-additiondate']


class FoodDetailsView(DetailView):
    model = FoodDetails
    template_name = 'food/FoodDetails_detail.html'


def CatList(request, pk):
    cate = FoodCategory.objects.all()
    lists = FoodDetails.objects.all()
    context = {
        'id': pk,
        'cate': cate,
        'list': lists
    }
    return render(request, 'food/flist.html', context)



