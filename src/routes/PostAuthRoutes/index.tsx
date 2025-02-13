import React from 'react';
import {createStackNavigator} from '@react-navigation/stack';
import {PostAuthStackParamList} from '../../types/routes';
import {Home} from '../../screens';

const Stack = createStackNavigator<PostAuthStackParamList>();

export const PostAuthStack = () => {
  return (
    <Stack.Navigator
      screenOptions={{
        headerShown: false,
      }}>
      <Stack.Screen name="Home" component={Home} />
    </Stack.Navigator>
  );
};
