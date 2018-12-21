from django.db import models
from django.utils import timezone
from django.contrib.auth.models import User
from django.urls import reverse


class FoodCategory(models.Model):
    categoryname = models.CharField(max_length=100)
    categorydetails = models.CharField(max_length=1000)
    categoryimage = models.ImageField(default='cat_def.jpg', upload_to='catimg')

    class Meta:
        verbose_name = 'Food Category'

    def __str__(self):
        return self.categoryname


class FoodDetails(models.Model):
    fromcategory = models.ForeignKey(FoodCategory, on_delete=models.CASCADE)
    foodname = models.CharField(max_length=100)
    fooddetails = models.CharField(max_length=1000)
    foodimage = models.ImageField(default='food_def.jpg', upload_to='fodimg')
    armodel = models.CharField(default='andy.sfb', max_length=50)
    additiondate = models.DateTimeField(default=timezone.now)
    longdetails = models.CharField(max_length=1000)

    class Meta:
        verbose_name = 'Food Detail'

    def __str__(self):
        return self.fromcategory.categoryname + \
               ' - ' + self.foodname

    def get_absolute_url(self):
        return reverse('food-details', kwargs={'pk': self.pk})
