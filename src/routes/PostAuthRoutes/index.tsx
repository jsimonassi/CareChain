import React from 'react';
import {createStackNavigator} from '@react-navigation/stack';
import {PostAuthStackParamList} from '../../types/routes';
import {Home} from '../../screens';
import {Location} from '../../screens/Location';
import {Bluetooth} from '../../screens/Bluetooth';
import {Profile} from '../../screens/Profile';
import {Scanning} from '../../screens/Scanning';

const Stack = createStackNavigator<PostAuthStackParamList>();

export const PostAuthStack = () => {
  return (
    <Stack.Navigator
      screenOptions={{
        headerShown: false,
      }}>
      {/* <Stack.Screen name="Home" component={Home} /> */}
      {/* <Stack.Screen name="Location" component={Location} /> */}
      {/* <Stack.Screen name="Bluetooth" component={Bluetooth} /> */}
      {/* <Stack.Screen name="Profile" component={Profile} /> */}
      <Stack.Screen name="Scanning" component={Scanning} />
    </Stack.Navigator>
  );
};
