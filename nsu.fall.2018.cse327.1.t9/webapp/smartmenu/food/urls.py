from django.urls import path, include
from . import views
from .views import FoodListView, FoodDetailsView, FoodCategoryView

# api url handler

urlpatterns = [
    path('category/', FoodCategoryView.as_view(), name='food-category'),
    path('foodlist/', FoodListView.as_view(), name='food-list'),
    path('foodlist/<int:pk>/', FoodDetailsView.as_view(), name='food-details'),
    path('catlist/<int:pk>/', views.CatList, name='catlist'),
]
